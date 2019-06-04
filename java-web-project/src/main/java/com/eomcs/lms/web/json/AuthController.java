package com.eomcs.lms.web.json;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.FacebookService;
import com.eomcs.lms.service.MemberService;

@RestController("json/AuthController")
@RequestMapping("/json/auth")
public class AuthController {

  final static Logger logger = LogManager.getLogger(AuthController.class);
  
  static final String REFERER_URL = "refererUrl";

  @Autowired MemberService memberService;
  @Autowired FacebookService facebookService;
  @Autowired ServletContext servletContext;
  
  @GetMapping("form")
  public void form(
      @RequestHeader(value="Referer",required=false) String refererUrl,
      HttpSession session) {
    
    logger.debug("refererUrl: " + refererUrl);
    
    if (refererUrl != null && !refererUrl.endsWith("/auth/login")) {
      session.setAttribute(REFERER_URL, refererUrl);
    } else {
      session.removeAttribute(REFERER_URL);
    }
  }
  
  @PostMapping("login")
  public Object login(
      String email,
      String password,
      HttpSession session,
      HttpServletResponse response) {

    Member member = memberService.get(email, password);

    HashMap<String,Object> content = new HashMap<>();
    
    if (member == null) {
      content.put("status", "fail");
      content.put("message", "이메일이 없거나 암호가 맞지 않습니다.");
    } else {
      session.setAttribute("loginUser", member);
      content.put("status", "success");
    }

    return content;
  }
  
  
  
  @GetMapping("logout")
  public Object logout(HttpSession session) throws Exception {
    
    logger.debug("세션 무효화시킴!");
    logger.debug("loginUser: " + session.getAttribute("loginUser"));
    session.invalidate();
    
    HashMap<String,Object> content = new HashMap<>();
    content.put("status", "success");
    
    return content;
  }
  
  @GetMapping("user")
  public Object user(HttpSession session) throws Exception {
    
    Member loginUser = (Member)session.getAttribute("loginUser");
    
    HashMap<String,Object> content = new HashMap<>();

    if (loginUser != null) {
      content.put("status", "success");
      content.put("user", loginUser);
    } else {
      content.put("status", "fail");
    }
    return content;
  }
  
  
  @GetMapping("fblogin")
  public Object fblogin(
      String accessToken,
      HttpSession session,
      HttpServletResponse response) {

    Map fbLoginUser = facebookService.getLoginUser(accessToken);
    
    Member member = memberService.get((String)fbLoginUser.get("email"));
    
    if (member == null) {
      member = new Member();
      member.setEmail((String)fbLoginUser.get("email"));
      member.setName((String)fbLoginUser.get("name"));
      member.setPassword(UUID.randomUUID().toString());

      // 소셜 사용자 정보를 DBMS에 등록한다.
      memberService.add(member);
    }
    
    session.setAttribute("loginUser", member);
    
    HashMap<String,Object> content = new HashMap<>();
    content.put("status", "success");
    content.put("member", member);

    return content;
  }
}











package cn.gzsxy.controller;

import cn.gzsxy.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回是String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("String测试成功");
        User user = new User();
        user.setUsername("路飞");
        user.setPassword("123");
        user.setAge(22);
        model.addAttribute("user",user);
        return "/success";
    }

    /**
     * 返回是void
     * 考虑请求转发和重定向
     * @param request
     * @param response
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response){
        System.out.println("testVoid被执行了");
        try {
            //请求转发
//            request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
            //重定向
//            response.sendRedirect(request.getContextPath()+"/redirect.jsp");
            //直接进行响应
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("hello");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 和返回字符串很相似
     * 返回是ModelAndView
     * @param
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建modelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView测试成功");

        User user = new User();
        user.setUsername("汉库克");
        user.setPassword("女帝");
        user.setAge(22);
        //添加user对象，会把user对象存入到request域里
        mv.addObject("user",user);
        //添加要跳转的页面
        mv.setViewName("/success");
        return mv;
    }

    /**
     * 模拟异步请求响应
     * @RequestBody获取整个请求体的内容
     * @param body
     */
    @RequestMapping("/Ajax")
    public void testAjax(@RequestBody String body){
        System.out.println("Ajax异步传输成功");
        System.out.println(body);
    }

}

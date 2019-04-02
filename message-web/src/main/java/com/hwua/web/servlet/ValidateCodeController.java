package com.hwua.web.servlet;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwua.util.CodeUtil;

@Controller

public class ValidateCodeController {
	@RequestMapping("/code")
	public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//得到包含验证码和图片缓冲区的值
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic(90,20,4,15,18,16);
		//禁止保存到浏览器缓存中
		resp.setHeader("Pragma","No-cache"); 
		resp.setHeader("Cache-Control","no-cache"); 
		resp.setDateHeader("Expires", 0); 
		StringBuilder code=(StringBuilder)codeMap.get("code");//得到后台生成的验证码
		//把验证码放到session中
		req.getSession().setAttribute("code", code.toString());
		
		//告知客户端浏览器,生成的是图片
        resp.setContentType("image/jpeg"); 
        ServletOutputStream out = resp.getOutputStream();//字节输出流
        ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg",out);
        out.close();
	}
}

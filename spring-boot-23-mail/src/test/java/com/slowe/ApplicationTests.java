package com.slowe;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private JavaMailSender mailSender;

	@Test
	public void contextLoads() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("yangdongdong_it@163.com");
		message.setTo("1049843090@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("邮件内容");
		mailSender.send(message);

	}

	@Test
	public void sendAttachmentsMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setFrom("yangdongdong_it@163.com");
		helper.setTo("1049843090@qq.com");
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");
		FileSystemResource file = new FileSystemResource(new File("E:\\TCP-IP.png"));
		helper.addAttachment("附件1", file);
		helper.addAttachment("附件2", file);
		mailSender.send(mimeMessage);

	}

	@Test
	public void sendInlineMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("yangdongdong_it@163.com");
		helper.setTo("1049843090@qq.com");
		helper.setSubject("主题：嵌入静态资源");
		helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);
		FileSystemResource file = new FileSystemResource(new File("E:\\github.jpg"));
		helper.addInline("weixin", file);
		mailSender.send(mimeMessage);
	}

	@Autowired
	private TemplateEngine templateEngine;

	@Test
	public void sendTemplateMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("yangdongdong_it@163.com");
		helper.setTo("1049843090@qq.com");
		helper.setSubject("主题：模板邮件");
		Map<String, Object> model = new HashMap<>();
		model.put("username", "yangdd");
		// 模板引擎的全局变量
		Context context = new Context();
		context.setLocale(Locale.CHINA);
		context.setVariables(model);
		String text = templateEngine.process("template", context);
		helper.setText(text, true);
		mailSender.send(mimeMessage);
	}

}

package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,12,12,12,12,13,13,15,15,16,16,18,18,18,18,18,18,18,19,19,19,21,21,22,22,24,24,24,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\r\n<html lang=\"ru\">\r\n    <head>\r\n        <title>Хекслет</title>\r\n        <meta charset=\"UTF-8\">\r\n        <meta name=\"viewport\"\r\n              content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n    </head>\r\n    <body>\r\n        <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\r\n        ");
		if (page.getCourses().isEmpty()) {
			jteOutput.writeContent("\r\n            <p>Пока не добавлено ни одного курса</p>\r\n        ");
		} else {
			jteOutput.writeContent("\r\n            ");
			for (var course : page.getCourses()) {
				jteOutput.writeContent("\r\n               <div>\r\n                   <h2><a href=\"/courses/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(course.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(course.getTitle());
				jteOutput.writeContent("</a></h2>\r\n                   <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(course.getDescription());
				jteOutput.writeContent("</p>\r\n               </div>\r\n            ");
			}
			jteOutput.writeContent("\r\n        ");
		}
		jteOutput.writeContent("\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}

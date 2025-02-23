package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.Page;
import gg.jte.Content;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,9,9,9,9,19,19,19,26,26,26,36,36,36,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Page page, Content content) {
		jteOutput.writeContent("\r\n<html lang=\"ru\">\r\n    <head>\r\n        <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</title>\r\n        <meta charset=\"UTF-8\">\r\n        <meta name=\"viewport\"\r\n              content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n    </head>\r\n    <body>\r\n        <header>\r\n            <div class=\"header\">\r\n                <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\r\n                <a href=\"/courses\">Перейти к курсам</a>\r\n            </div>\r\n        </header>\r\n\r\n        <main>\r\n            <div class=\"content\">\r\n                ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n            </div>\r\n        </main>\r\n\r\n    </body>\r\n        <footer>\r\n            <div class=\"footer\">\r\n                <a href=\"github.com/dellup\">Ссылка на гитхаб</a>\r\n            </div>\r\n        </footer>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Page page = (Page)params.get("page");
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, page, content);
	}
}

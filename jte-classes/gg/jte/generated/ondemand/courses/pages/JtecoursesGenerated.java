package gg.jte.generated.ondemand.courses.pages;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
public final class JtecoursesGenerated {
	public static final String JTE_NAME = "courses/pages/courses.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,9,9,11,11,13,13,13,13,13,13,13,13,13,25,25,27,27,27,27,27,27,27,28,28,28,29,29,29,31,31,35,35,37,37,37,37,37,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage coursesPage) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.courses.JteindexGenerated.render(jteOutput, jteHtmlInterceptor, coursesPage, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <ul>\r\n        ");
				if (coursesPage.getCourses().isEmpty()) {
					jteOutput.writeContent("\r\n        <p>Пользователей пока нет.</p>\r\n        ");
				} else {
					jteOutput.writeContent("\r\n        <form action=\"/courses\" method=\"get\">\r\n            <input type=\"search\" required name=\"term\"");
					var __jte_html_attribute_0 = coursesPage.getTerm();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("input", "value");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("input", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\r\n            <input type=\"submit\" value=\"Искать\">\r\n        </form>\r\n        <table class=\"table\">\r\n            <thead>\r\n            <tr>\r\n                <th scope=\"col\">#</th>\r\n                <th scope=\"col\">Title</th>\r\n                <th scope=\"col\">Description</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody>\r\n            ");
					for (Course course : coursesPage.getCourses()) {
						jteOutput.writeContent("\r\n            <tr>\r\n                <th scope=\"row\"><a href=\"/courses/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(course.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(course.getId());
						jteOutput.writeContent("</a></th>\r\n                <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(course.getTitle());
						jteOutput.writeContent("</td>\r\n                <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(course.getDescription());
						jteOutput.writeContent("</td>\r\n            </tr>\r\n            ");
					}
					jteOutput.writeContent("\r\n            </tbody>\r\n        </table>\r\n\r\n        ");
				}
				jteOutput.writeContent("\r\n    </ul>\r\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage coursesPage = (CoursesPage)params.get("coursesPage");
		render(jteOutput, jteHtmlInterceptor, coursesPage);
	}
}

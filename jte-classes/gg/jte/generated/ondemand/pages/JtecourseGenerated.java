package gg.jte.generated.ondemand.pages;
import org.example.hexlet.dto.courses.CoursePage;
public final class JtecourseGenerated {
	public static final String JTE_NAME = "pages/course.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,7,7,7,8,8,8,9,9,9,9,9,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage coursePage) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.JteindexGenerated.render(jteOutput, jteHtmlInterceptor, coursePage, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h2>");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent(coursePage.getCourse().getTitle());
				jteOutput.writeContent("</h2>\r\n    <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(coursePage.getCourse().getDescription());
				jteOutput.writeContent("</p>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage coursePage = (CoursePage)params.get("coursePage");
		render(jteOutput, jteHtmlInterceptor, coursePage);
	}
}

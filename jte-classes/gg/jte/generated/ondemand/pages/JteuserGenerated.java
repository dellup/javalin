package gg.jte.generated.ondemand.pages;
import org.example.hexlet.dto.users.UserPage;
public final class JteuserGenerated {
	public static final String JTE_NAME = "pages/user.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,7,7,7,8,8,8,8,8,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage userPage) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.JteindexGenerated.render(jteOutput, jteHtmlInterceptor, userPage, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<h2>");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent(userPage.getUser().getName());
				jteOutput.writeContent("</h2>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage userPage = (UserPage)params.get("userPage");
		render(jteOutput, jteHtmlInterceptor, userPage);
	}
}

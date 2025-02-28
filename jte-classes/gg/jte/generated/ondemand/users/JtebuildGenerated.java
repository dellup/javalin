package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.Page;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,2,5,5,33,33,33,33,33,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Page buildPage) {
		gg.jte.generated.ondemand.JteindexGenerated.render(jteOutput, jteHtmlInterceptor, buildPage, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<form action=\"/users\" method=\"post\" class=\"p-4\">\r\n    <div>\r\n        <label>\r\n            Имя\r\n            <input type=\"text\" name=\"name\" />\r\n        </label>\r\n    </div>\r\n    <div>\r\n        <label>\r\n            Email\r\n            <input type=\"email\" required name=\"email\" />\r\n        </label>\r\n    </div>\r\n    <div>\r\n        <label>\r\n            Пароль\r\n            <input type=\"password\" required name=\"password\" />\r\n        </label>\r\n    </div>\r\n    <div>\r\n        <label>\r\n            Подтверждение пароля\r\n            <input type=\"password\" required name=\"passwordConfirmation\" />\r\n        </label>\r\n    </div>\r\n    <input type=\"submit\" value=\"Зарегистрировать\" />\r\n</form>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Page buildPage = (Page)params.get("buildPage");
		render(jteOutput, jteHtmlInterceptor, buildPage);
	}
}

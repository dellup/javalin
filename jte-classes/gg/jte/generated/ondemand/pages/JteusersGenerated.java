package gg.jte.generated.ondemand.pages;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.dto.NamedRoutes;
import org.example.hexlet.model.User;
public final class JteusersGenerated {
	public static final String JTE_NAME = "pages/users.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,8,8,10,10,12,12,13,13,13,13,13,13,13,13,13,14,14,14,14,14,14,14,14,14,27,27,29,29,29,29,29,29,29,29,29,29,29,29,30,30,30,31,31,31,32,32,32,34,34,38,38,40,40,40,40,40,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage usersPage) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.JteindexGenerated.render(jteOutput, jteHtmlInterceptor, usersPage, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<ul>\r\n    ");
				if (usersPage.getUsers().isEmpty()) {
					jteOutput.writeContent("\r\n    <p>Пользователей пока нет.</p>\r\n    ");
				} else {
					jteOutput.writeContent("\r\n    <form");
					var __jte_html_attribute_0 = NamedRoutes.usersPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"get\">\r\n        <input type=\"search\" required name=\"term\"");
					var __jte_html_attribute_1 = usersPage.getTerm();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("input", "value");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("input", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\r\n        <input type=\"submit\" value=\"Искать\">\r\n    </form>\r\n    <table class=\"table\">\r\n        <thead>\r\n        <tr>\r\n            <th scope=\"col\">#</th>\r\n            <th scope=\"col\">Name</th>\r\n            <th scope=\"col\">Email</th>\r\n            <th scope=\"col\">Created at</th>\r\n        </tr>\r\n        </thead>\r\n        <tbody>\r\n        ");
					for (User user : usersPage.getUsers()) {
						jteOutput.writeContent("\r\n        <tr>\r\n            <th scope=\"row\"><a");
						var __jte_html_attribute_2 = NamedRoutes.userPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_2);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</a></th>\r\n            <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</td>\r\n            <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</td>\r\n            <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getCreatedAt().toString());
						jteOutput.writeContent("</td>\r\n        </tr>\r\n        ");
					}
					jteOutput.writeContent("\r\n        </tbody>\r\n    </table>\r\n\r\n    ");
				}
				jteOutput.writeContent("\r\n</ul>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage usersPage = (UsersPage)params.get("usersPage");
		render(jteOutput, jteHtmlInterceptor, usersPage);
	}
}

@import org.example.hexlet.dto.users.UserPage
@param UserPage userPage

@template.index(
page = userPage,
content = @`
<h2>${userPage.getUser().getName()}</h2>
`
)
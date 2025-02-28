@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage coursePage

@template.index(
page = coursePage,
content = @`
    <h2>${coursePage.getCourse().getTitle()}</h2>
    <p>${coursePage.getCourse().getDescription()}</p>
`
)
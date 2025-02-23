@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage coursePage

@template.courses.index(
page = coursePage,
content = @`
<div class="content">
    <h2>${coursePage.getCourse().getTitle()}</h2>
    <p>${coursePage.getCourse().getDescription()}</p>
</div>
`
)
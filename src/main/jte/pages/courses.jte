@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.model.Course
@import org.example.hexlet.dto.NamedRoutes
@param CoursesPage coursesPage

@template.index(
    page = coursesPage,
    content = @`
    <ul>
        @if (coursesPage.getCourses().isEmpty())
        <p>Такого курса нет или курсы еще не добавлены</p>
        @else
        <form action="${NamedRoutes.coursesPath()}" method="get">
            <input type="search" required name="term" value="${coursesPage.getTerm()}">
            <input type="submit" value="Искать">
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
            </tr>
            </thead>
            <tbody>
            @for (Course course : coursesPage.getCourses())
            <tr>
                <th scope="row"><a href="${NamedRoutes.coursePath(course.getId())}">${course.getId()}</a></th>
                <td>${course.getTitle()}</td>
                <td>${course.getDescription()}</td>
            </tr>
            @endfor
            </tbody>
        </table>

        @endif
    </ul>
    `
)
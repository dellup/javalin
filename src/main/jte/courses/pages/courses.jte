@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.model.Course
@param CoursesPage coursesPage

@template.courses.index(
    page = coursesPage,
    content = @`
    <ul>
        @if (coursesPage.getCourses().isEmpty())
        <p>Пользователей пока нет.</p>
        @else
        <form action="/courses" method="get">
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
                <th scope="row"><a href="/courses/${course.getId()}">${course.getId()}</a></th>
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
@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.dto.NamedRoutes
@import org.example.hexlet.model.User
@param UsersPage usersPage

@template.index(
page = usersPage,
content = @`
<ul>
    @if (usersPage.getUsers().isEmpty())
    <p>Пользователей пока нет.</p>
    @else
    <form action="${NamedRoutes.usersPath()}" method="get">
        <input type="search" required name="term" value="${usersPage.getTerm()}">
        <input type="submit" value="Искать">
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Created at</th>
        </tr>
        </thead>
        <tbody>
        @for (User user : usersPage.getUsers())
        <tr>
            <th scope="row"><a href="${NamedRoutes.userPath(user.getId())}">${user.getId()}</a></th>
            <td>${user.getName()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getCreatedAt().toString()}</td>
        </tr>
        @endfor
        </tbody>
    </table>

    @endif
</ul>
`
)
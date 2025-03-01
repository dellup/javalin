@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.dto.NamedRoutes
@param BuildUserPage buildPage
@template.index(
page = buildPage,
content = @`
@if(buildPage.getErrors() != null)
<ul>
    @for(var validator : buildPage.getErrors().values())
        @for(var error : validator)
            <li>${error.getMessage()}</li>
        @endfor
    @endfor
</ul>
@endif
<form action="${NamedRoutes.usersPath()}" method="post" class="p-4">
    <div>
        <label>
            Имя
            <input type="text" name="name" value="${buildPage.getName()}"/>
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email" required name="email" value="${buildPage.getEmail()}"/>
        </label>
    </div>
    <div>
        <label>
            Пароль
            <input type="password" required name="password" />
        </label>
    </div>
    <div>
        <label>
            Подтверждение пароля
            <input type="password" required name="passwordConfirmation" />
        </label>
    </div>
    <input type="submit" value="Зарегистрировать" />
</form>
`
)
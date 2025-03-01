@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage buildPage
@template.index(
page = buildPage,
content = @`
<form action="/users" method="post" class="p-4">
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
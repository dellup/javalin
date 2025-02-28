@import org.example.hexlet.dto.Page
@param Page buildPage
@template.index(
page = buildPage,
content = @`
<form action="/users" method="post" class="p-4">
    <div>
        <label>
            Имя
            <input type="text" name="name" />
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email" required name="email" />
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
@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.dto.Page
@import gg.jte.Content

@param Page page
@param Content content

<html lang="ru">
    <head>
        <title>${page.getHeader()}</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <header>
            <div class="header">
                <h1>${page.getHeader()}</h1>
                <div><a href="/courses">Перейти к курсам</a></div>
                <div><a href="/users">Перейти к пользователям</a></div>
            </div>
        </header>

        <main>
            <div class="content">
                ${content}
            </div>
        </main>

    </body>
        <footer>
            <div class="footer">
                <a href="github.com/dellup">Ссылка на гитхаб</a>
            </div>
        </footer>
</html>
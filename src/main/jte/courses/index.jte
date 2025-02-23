@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<html lang="ru">
    <head>
        <title>Хекслет</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
    </head>
    <body>
        <h1>${page.getHeader()}</h1>
        @if(page.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var course : page.getCourses())
               <div>
                   <h2><a href="/courses/${course.getId()}">${course.getTitle()}</a></h2>
                   <p>${course.getDescription()}</p>
               </div>
            @endfor
        @endif
    </body>
</html>
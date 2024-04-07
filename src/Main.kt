fun main() {
    var check = ToDoList()
    while (true){
    println("""
        Это наши заметки!
        1. Новая заметка!         3. обновить статус заметки
        2. Удалить заметку :(     4.вывести все заметки
    """.trimIndent())


    var choice = readln().toInt()
        when (choice) {
            1 -> check.NewTask()
            2 -> check.DelTask()
            3 -> check.DoneTask()
            4 -> check.AllTask()
        }
}}
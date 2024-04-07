import jdk.incubator.vector.VectorOperators.Test

class ToDoList : TaskManager {
    var Tasks: MutableList<Task> = mutableListOf()

    override fun NewTask() {
        println("Введите название")
        val taskName = readLine()!!
        println("Введите описание")
        val taskDesk = readLine()!!
        println("Введите дату заметки ")
        val taskdate = readLine()!!
        println("Введите приоритетность заметки")
        val taskPriority = readLine()!!.toInt()
        println("Введите, выполнена заметка, или нет? (true/false)")
        val taskDone = readLine()!!.toBoolean()
        val task = Task(taskName, taskDesk, taskdate, taskPriority, taskDone)
        Tasks.add(task)
    }

    override fun DelTask() {

        if (Tasks.count() > 0) {
            var counter: Int = 0
            for (i in Tasks) {
                counter++
                println("${counter} ${i.task_name}  ${i.task_desk}  ${i.task_date} ${i.task_priority} ${i.task_done}")
            }
        } else {
            println("список заметок пуст")
        }
        println("какую заметку удаляем?")
        val choice: Int = readLine()!!.toInt()
        if (choice > 0 && choice <= Tasks.size) {
            Tasks.removeAt(choice - 1)
        } else {
            println("Некорректный выбор.")
        }
    }

    override fun DoneTask() {
        if (Tasks.count() > 0) {
            var counter: Int = 0
            for (i in Tasks) {
                if (i.task_done == false) {
                    counter++
                    println("${counter} ${i.task_name}  ${i.task_desk}  ${i.task_date} ${i.task_priority} ${i.task_done}")
                }
            }
        } else {
            println("список заметок пуст")
        }
        println("какая задача выполнена?")
        val choice: Int = readLine()!!.toInt()
        if (choice > 0 && choice <= Tasks.size) {
            for (choice in Tasks) {
                choice.task_done = true
                println("готово")
            }
        } else {
            println("Некорректный выбор.")
        }
    }

    override fun AllTask() {
        if (Tasks.count() > 0) {
            var counter: Int = 0
            for (i in Tasks) {
                counter++
                println("${counter} ${i.task_name}  ${i.task_desk}  ${i.task_date} ${i.task_priority} ${i.task_done}")
            }
        } else {
            println("список заметок пуст")
        }
        println(
            """
            сортируем?
            1. - да
            2. - нет :(
        """.trimIndent()
        )
        val choice: Int = readLine()!!.toInt()
        if (choice == 1) {
            println(
                """
                как сортируем?
                1. - по названию
                2. - по приоритету
            """.trimIndent()
            )
            val choice: Int = readLine()!!.toInt()
            if (choice == 1) {
                val extraword:String = readLine()!!
                var counter: Int = 0
                for (i in Tasks){
                    counter++
                    if(extraword == i.task_name)
                    println("${counter} ${i.task_name}  ${i.task_desk}  ${i.task_date} ${i.task_priority} ${i.task_done}")
                }
            } else if (choice == 2) {
                Tasks.sortBy { it.task_priority }

                var counter: Int = 0
                for (i in Tasks) {
                    counter++
                    println("${counter} ${i.task_name}  ${i.task_desk}  ${i.task_date} ${i.task_priority} ${i.task_done}")
                }
            } else {
                println("список заметок пуст")
            }


        } else {
            println("ладно :(")
        }
    }
}
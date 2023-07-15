from tools.objective import Objective


class Run:
    def run_main(self):
        text_main_menu = "Меню:\n" \
                         "1. Новая заметка\n" \
                         "2. Открыть все заметки\n" \
                         "3. Редактировать заметку\n" \
                         "4. Поиск по номеру заметки\n" \
                         "5. Выборка по дате\n" \
                         "6. Сортировка по дате\n" \
                         "7. Удалить заметку\n" \
                         "8. Выход\n"
        print(text_main_menu)
        try:
            choice = int(input())
        except ValueError:
            print("Некорректный ввод. Повторите попытку: ")
            self.main_menu()
        else:
            return choice


    def main_menu(self):
        tools = Objective()
        choice = self.run_main()
        match choice:
            case 1:
                tools.add_note()
                self.main_menu()
            case 2:
                tools.print_all_notes()
                self.main_menu()
            case 3:
                tools.edit_note()
                self.main_menu()
            case 4:
                tools.print_note()
                self.main_menu()
            case 5:
                tools.range_by_date()
                self.main_menu()
            case 6:
                tools.print_sorted_notes_by_datetime()
                self.main_menu()
            case 7:
                tools.delete_note()
                self.main_menu()
            case 8:
                print("Выход")
                exit()

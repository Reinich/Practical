from tools.handler import Tools


class Objective:
    def add_note(self):
        hd = Tools()
        objs = hd.read_file()
        line_head = str(input("Заголовок: "))
        line = str(input("Новая заметка: "))
        note_dict = {"id_note": hd.check_last_id() + 1,
                     "head": line_head,
                     "body": line,
                     "edit_date": hd.get_current_time()}
        if not objs:
            hd.json_dump([note_dict])
        else:
            objs.append(note_dict)
            hd.json_dump(objs)

    def print_all_notes(self):
        hd = Tools()
        contains = hd.read_file()
        for el in contains:
            hd.print_formatted(el)

    def print_sorted_notes_by_datetime(self):
        hd = Tools()
        objs = hd.read_file()
        array_id = []
        for el in objs:
            array_id.append(el["edit_date"])
        sorted_array_id = sorted(array_id)
        for i in range(len(objs)):
            for el in objs:
                if sorted_array_id[i] == el["edit_date"]:
                    hd.print_formatted(el)

    def edit_note(self):
        hd = Tools()
        try:
            number_note = int(input("Номер заметки: "))
        except ValueError:
            print("Некорректный ввод. Повторите попытку:\n")
            self.edit_note()
        else:
            if hd.find_id_note(number_note):
                choice = int(input("1. Редактирование заголовка\n"
                                   "2. Редактирование содержимого\n"
                                   "3. Выход\n"))
                if choice == 1:
                    objs = hd.read_file()
                    for el in objs:
                        if el["id_note"] == number_note:
                            change_head = input("Новый заголовок: ")
                            el["head"] = change_head
                            el["edit_date"] = hd.get_current_time()
                    hd.json_dump(objs)

                elif choice == 2:
                    objs = hd.read_file()
                    for el in objs:
                        if el["id_note"] == number_note:
                            change_body = input("Новое содержимое: ")
                            el["body"] = change_body
                            el["edit_date"] = hd.get_current_time()
                    hd.json_dump(objs)

                else:
                    print("Выход из редактирования")

            else:
                print("Заметка не найдена\n")

    def print_note(self):
        hd = Tools()
        try:
            number_note = int(input("Номер заметки: "))
        except ValueError:
            print("Некорректный ввод. Повторите попытку:\n")
            self.print_note()
        else:
            contains = hd.read_file()
            if hd.find_id_note(number_note):
                for el in contains:
                    if el["id_note"] == number_note:
                        hd.print_formatted(el)
            else:
                print("Заметка не найдена\n")

    def delete_note(self):
        hd = Tools()
        try:
            number_note = int(input("Номер заметки: "))
        except ValueError:
            print("Некорректный ввод. Повторите попытку:\n")
            self.delete_note()
        else:
            if hd.find_id_note(number_note):
                objs = hd.read_file()
                for el in objs:
                    if el["id_note"] == number_note:
                        objs.remove(el)
                hd.json_dump(objs)
                print("Заметка №{} успешно удалена.\n".format(number_note))

            else:
                print("Заметка не найдена\n")

    def range_by_date(self):
        hd = Tools()
        date_start = "-".join(input("Введите начальную дату через пробел (yyyy mm dd): ").split(" "))
        date_end = "-".join(input("Введите конечную дату через пробел (yyyy mm dd): ").split(" "))
        if hd.find_note_by_datetime(date_start, date_end):
            objs = hd.read_file()
            for el in objs:
                if date_start <= el["edit_date"].partition(" ")[0] <= date_end:
                    hd.print_formatted(el)
        else:
            print("Заметок с {} по {} не найдено\n".format(date_start, date_end))

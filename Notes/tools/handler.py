import json
import locale
from datetime import date, datetime


class Tools:
    def __init__(self):
        self.local_coding = locale.getpreferredencoding()
    def json_dump(self, content):
        with open('note.json', 'w', encoding=self.local_coding) as file:
            json.dump(content, file, indent=4, ensure_ascii=False)

    def read_file(self):
        try:
            with open('note.json') as file:
                return json.load(file)
        except FileNotFoundError:
            print('Файл отсутствует.\nСоздается новый.\n')
            with open('note.json', 'w', encoding=locale.getpreferredencoding()) as file:
                file.write('[]')
            with open('note.json') as file:
                return json.load(file)

    def get_current_time(self):
        current_date, current_time = date.today(), datetime.now().time()
        current_time_f = f'{current_time.hour}:{current_time.minute}:{current_time.second}'
        return f'{current_date} {current_time_f}'

    def check_last_id(self):
        objs = self.read_file()
        current_value = []
        if not objs:
            return 0
        for el in objs:
            for k, v in el.items():
                if k == "id_note":
                    current_value.append(v)
        return max(current_value)

    def print_formatted(self, el):
        print("\nНомер заметки: {}\n"
              "Заголовок: {}\n"
              "\t{}\n"
              "Дата: {}\n".format(el["id_note"], el["head"], el["body"], el["edit_date"]))

    def find_id_note(self, id_needed):
        objs = self.read_file()
        for el in objs:
            if id_needed == el["id_note"]:
                return True

    def find_note_by_datetime(self, date_start, date_end):
        objs = self.read_file()
        for el in objs:
            if date_start <= el["edit_date"].partition(" ")[0] <= date_end:
                return True

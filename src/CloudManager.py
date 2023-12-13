from CustomError import FileNotFound, StockageInsufisantCloud
from FileObject import FileObject


class CloudManager:
    def __init__(self):
        self.files = []

    def upload_file(self):
        filename = input("Enter filename: ")
        file_type = input("Enter file type: ")
        extension = input("Enter file extension: ")
        size = int(input("Enter file size in MB: "))

        try:
            if self.check_storage(size):
                file_object = FileObject(filename, file_type, extension, size)
                self.files.append(file_object)
                print(f"File '{filename}' uploaded successfully!")
            else:
                raise StockageInsufisantCloud(size)
        except StockageInsufisantCloud as e:
            print(f"Error: Cloud storage insufficient ({e.size} MB).")
        except Exception as e:
            print(f"Unexpected error: {e}")

    def download_file(self):
        filename = input("Enter filename to download: ")

        try:
            print(f"File '{filename}' downloaded successfully!")
        except FileNotFound as e:
            print(f"Error: File not found ({e.filename})")
        except Exception as e:
            print(f"Unexpected error: {e}")

    def show_file_info(self):
        filename = input("Enter filename to see info: ")

        try:
            file_object = self.find_file(filename)
            print(f"Filename: {file_object.filename}")
            print(f"File type: {file_object.file_type}")
            print(f"File extension: {file_object.extension}")
            print(f"File size: {file_object.size} MB")
        except FileNotFound as e:
            print(f"Error: File not found ({e.filename})")
        except Exception as e:
            print(f"Unexpected error: {e}")

    def show_all_files(self):
        if self.files:
            for file_object in self.files:
                print(f"{file_object.filename} ({file_object.size} MB)")
        else:
            print("No files stored in the cloud.")

    def check_storage(self, size):
        cloud_size = 100
        return size < cloud_size

    def find_file(self, filename):
        for file_object in self.files:
            if file_object.filename == filename:
                return file_object
        raise FileNotFound(filename)

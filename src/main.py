# Main program
from CloudManager import CloudManager


cloud_manager = CloudManager()

while True:
    action = input("""
Choose an action:

1. Upload file
2. Download file
3. Show file info
4. Show all files
5. Exit

Enter your choice: """)

    if action == "1":
        cloud_manager.upload_file()
    elif action == "2":
        cloud_manager.download_file()
    elif action == "3":
        cloud_manager.show_file_info()
    elif action == "4":
        cloud_manager.show_all_files()
    elif action == "5":
        break
    else:
        print("Invalid choice. Please enter a valid number (1-5).")

print("Good bye!")

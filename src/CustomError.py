class StockageInsufisantCloud(Exception):
    def __init__(self, size):
        self.size = size

class FileNotFound(Exception):
    def __init__(self, filename):
        self.filename = filename
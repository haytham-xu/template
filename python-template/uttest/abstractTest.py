
import unittest

class AbstractTestCase(unittest.TestCase):

    @classmethod
    def setUpClass(self):
        pass # beforeAll

    @classmethod 
    def tearDownClass(self):
        pass # afterAll

import pytest
from selenium import webdriver
from pages.caseStudyTwo import *

@pytest.fixture(scope="module")
def driver_init():
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get("https://www.saucedemo.com/")
    yield driver
    driver.quit()

@pytest.mark.usefixtures("driver_init")
class TestCaseStudyTwo:
    def test_CaseStudyTwo_scenario(self,driver_init):
        page = CaseStudyTwo(driver_init)
        page.Verify_SwagLabs_Text()
        page.click_addtocart()
        page.verify_selectedcart()
        page.click_logout()






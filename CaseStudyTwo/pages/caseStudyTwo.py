import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains


class CaseStudyTwo:
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)  
        self.action = ActionChains(driver)

    swaglabs="//div[contains(text(),'Swag Labs')]"
    username="//input[@id='user-name']"
    password="//input[@id='password']"
    login="//input[@id='login-button']"
    expected_text="Swag Labs"
    addcart="//button[@id='add-to-cart-sauce-labs-backpack']"
    continueShopping="//button[@id='continue-shopping']"
    selectedcart="//a[@class='shopping_cart_link']"
    menu="//button[contains(text(),'Open Menu')]"
    qtyselected="//div[@class='cart_item']/div[contains(text(),'1')]"
    logout="//a[contains(text(),'Logout')]"

# Generic Functions
    def Verify_SwagLabs_Text(self):  
        # Verify SwagLabs Test      
        self.driver.find_element(By.XPATH,self.username).send_keys("standard_user")
        self.driver.find_element(By.XPATH,self.password).send_keys("secret_sauce")
        self.driver.find_element(By.XPATH,self.login).click()
            # Wait up to 10 seconds for the text to be present 
        element = self.wait.until(
        EC.presence_of_element_located((By.XPATH,self.swaglabs))
    )
        assert self.expected_text in element.text, f"Expected text '{self.expected_text}' not found on the webpage!"
        print(f"Expected text '{self.expected_text}' found on the webpage!") 

 
    def click_addtocart(self):   
        addToCart = self.wait.until(
        EC.presence_of_element_located((By.XPATH,self.addcart)))
        addToCart.click()
        time.sleep(2)    

    def verify_selectedcart(self):
        self.driver.find_element(By.XPATH,self.selectedcart).click()
        time.sleep(2)
        selectedQuantity=self.driver.find_element(By.XPATH,self.qtyselected)
        if selectedQuantity.is_displayed():
            # print("Item added to Cart")
            self.driver.find_element(By.XPATH,self.continueShopping).click()


    def click_logout(self):     
        self.driver.find_element(By.XPATH,self.menu).click()
        time.sleep(2)
        self.driver.find_element(By.XPATH,self.logout).click()
        time.sleep(2)      

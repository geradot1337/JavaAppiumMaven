package lib.ui.mobileWeb;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject
    {
      static {
          TITLE = "css:#content h1";

OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions li.ca-watch.page-actions-watch watched button";
          ADD_TO_MY_READING_LIST_OVERLAY = "css:#page-actions li.#ca-watch button";

          FOOTER_ELEMENT = "css:footer-info";
      }
        public MWArticlePageObject(RemoteWebDriver driver)
        {
            super(driver);
        }
}

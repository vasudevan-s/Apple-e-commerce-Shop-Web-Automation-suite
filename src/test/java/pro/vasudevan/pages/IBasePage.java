package pro.vasudevan.pages;

import org.openqa.selenium.WebElement;
import pro.vasudevan.automation.unifiedtestframework.interfaces.IImageHelper;

import java.util.List;
import java.util.function.Supplier;

import static pro.vasudevan.misc.Global.rootMediaPath;

/*
Created By: Vasudevan Sampath

IBasePage.java has common methods for all the POM page classes
*/
public interface IBasePage {

    static boolean areImagesIdentical(int imageFileNameBeginCounter, Supplier<List<WebElement>> supplier) throws Exception {
        boolean isImageMatching = true;
        List<WebElement> imageLinks = supplier.get();
        for (WebElement imageElement : imageLinks) {
            String imageLink = imageElement.getAttribute("src");
            if (!IImageHelper.compareImage(imageLink, rootMediaPath + "homepage-products/" + imageFileNameBeginCounter + ".png")) {
                isImageMatching = false;
                break;
            }
            imageFileNameBeginCounter++;
        }
        return isImageMatching;
    }
}

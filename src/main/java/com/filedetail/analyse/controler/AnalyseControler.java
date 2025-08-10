package com.filedetail.analyse.controler;

import com.filedetail.analyse.service.AnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnalyseControler {
    @Autowired
    private AnalyseService analyseService;

    @GetMapping(value = "analyse")
    @ResponseStatus(HttpStatus.OK)
    public String getAnalyse()  {
        analyseService.getFileInfo("a","b");
        return "Hello";
    }
/*
Exemple d'appel : http://localhost:8099/infoAnalyse?fileName=D:/Documents E/git/PictureAnalyse-V0/picture&filePath=2021-Mars-DSC_0637.NEF
 */
    @GetMapping(value = "infoAnalyse")
    public List<String> getInfoAnalyse(@RequestParam(name = "filePath") String filePath,@RequestParam(name = "fileName") String fileName)  {
        List<String> resultList = new ArrayList<>();
        if (fileName.isEmpty() || filePath.isEmpty())
        {
            resultList.add("fileName or filePath is empty");
        }
        else {
            resultList = analyseService.getInfoAnalyse(filePath,fileName);
        }

        return resultList;
    }
    
    /* Controler pour récupérer uniquement le Exposure Sequence Number en Nikon*/
    @GetMapping(value = "getNikonExposureSequenceNumber")
    public String getNikonExposureSequenceNumber(@RequestParam(name = "filePath") String filePath,@RequestParam(name = "fileName") String fileName)  {
        String resultNikonESN = "";
        if (fileName.isEmpty() || filePath.isEmpty())
        {
        	resultNikonESN="fileName or filePath is empty";
        }
        else {
        	resultNikonESN = analyseService.getNikonExposureSequenceNumber(filePath,fileName); //CHANGER ICICICICICIC avec la nouvelle fonction
        }
        if (resultNikonESN.isEmpty()) {
        	resultNikonESN = "Non trouvé";
        }
        return resultNikonESN;
    }
}

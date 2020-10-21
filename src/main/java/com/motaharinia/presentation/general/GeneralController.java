package com.motaharinia.presentation.general;


import com.motaharinia.business.service.etcitem.EtcItemService;
import com.motaharinia.msutility.json.CustomObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GeneralController {

    private final EtcItemService etcItemService;

    @Autowired
    public GeneralController(EtcItemService etcItemService) {
        this.etcItemService = etcItemService;
    }

    @GetMapping("/getCombo")
    HashMap<String, List<Object[]>> getCombo(@RequestParam(name = "post") Optional<String> post) throws Exception {
        //تبدیل جیسون به هش مپ HashMap<String, HashMap<String, Object>>
        CustomObjectMapper customObjectMapper = new CustomObjectMapper();
        HashMap<String, HashMap<String, Object>> initialHashMap = customObjectMapper.readValue(post.get(), HashMap.class);

        String inputId, entityName, parametersMode;
        HashMap<String, Object> valueHashMap;

        HashMap<String, List<Object[]>> returnHashmap = new HashMap<>();
        List<Object[]> listObject ;
        for (Map.Entry<String, HashMap<String, Object>> entry : initialHashMap.entrySet()) {

            listObject = new ArrayList<>();
            inputId = entry.getKey();
            valueHashMap = entry.getValue();

            entityName = (String) valueHashMap.get("entity");
            parametersMode = (String) valueHashMap.get("parametersMode");

            switch (entityName) {
                case "etcItem":
                    switch (parametersMode) {
                        case "gender":
                            listObject = etcItemService.combo(parametersMode, false, false);
                            break;
                    }
            }

            if (!ObjectUtils.isEmpty(listObject)) {
                returnHashmap.put(inputId, listObject);
            }
        }
        return returnHashmap;
    }


}

package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;
    public MergerController(DinerRepository diner, PancakeHouseRepository pancake) {
        this.dinerRepository = diner;
        this.pancakeHouseRepository = pancake;
    }
    private static Comparator<MenuItem> ALPHABETICAL_ORDER = new Comparator<MenuItem>() {
        public int compare(MenuItem str1, MenuItem str2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(str1.getName(), str2.getName());
            if (res == 0) {
                res = str1.getName().compareTo(str2.getName());
            }
            return res;
        }
    };
    @GetMapping
    public List<MenuItem> getAll() {
        List<MenuItem> allItems = new ArrayList<>();

        allItems.addAll(Arrays.asList(dinerRepository.getTheMenu()));
        allItems.addAll(pancakeHouseRepository.getTheMenu());
        allItems.sort(ALPHABETICAL_ORDER);
        return allItems;
    }

}

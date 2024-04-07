package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
       this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }
    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarianMenuItems() {
        return get()
                .stream()
                .filter(MenuItemRecord::vegetarian)
                .collect(Collectors.toList());
    }
    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfastMenuItems() {
        return mergerRepository.getBreakfastItems();
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunchMenuItems() {
        return mergerRepository.getLunchItems();
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getSupperMenuItems() {
        return mergerRepository.getDinnerItems();
    }

}

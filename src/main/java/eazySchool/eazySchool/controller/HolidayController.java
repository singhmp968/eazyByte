package eazySchool.eazySchool.controller;

import eazySchool.eazySchool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {
    @GetMapping("/holidays")
    public String displayHolidayPage(Model model){
        List<Holiday> holidays = List.of(
            new Holiday("01/01/2021","New Year Day",Holiday.Type.FEDERAL),
            new Holiday("02/14/2021","Valentine's Day",Holiday.Type.FESTIVAL),
            new Holiday("05/25/2021","Memorial Day",Holiday.Type.FEDERAL),
            new Holiday("07/04/2021","Independence Day",Holiday.Type.FESTIVAL),
            new Holiday("09/07/2021","Labor Day",Holiday.Type.FEDERAL),
            new Holiday("11/11/2021","Veterans Day",Holiday.Type.FESTIVAL),
            new Holiday("11/24/2021","Thanksgiving",Holiday.Type.FEDERAL),
            new Holiday("12/25/2021","Christmas",Holiday.Type.FESTIVAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream()
                    .filter(holiday -> holiday.getType().equals(type))
                    .collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}

package org.springframework.social.skplanetx.sample.controller.melon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.skplanetx.api.Skplanetx;
import org.springframework.social.skplanetx.api.melon.dto.Melon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bungubbang
 * Email: sungyong.jung@sk.com
 * Date: 7/15/14
 */
@Controller
@RequestMapping("/melon/chart")
public class MelonChartController {

    @Autowired
    private Skplanetx skplanetx;

    @RequestMapping("/realtime")
    public String realtime(ModelMap map) {

        Melon realTime = skplanetx.getMelon().getChart().getRealTime(1, 100);
        map.addAttribute("realTime", realTime);
        return "melon/chart/realtime";
    }

    @RequestMapping("/todaytopsongs")
    public String todaytopsongs(ModelMap map) {

        Melon todaytopsongs = skplanetx.getMelon().getChart().getTodayTopSongs(1, 100);
        map.addAttribute("todaytopsongs", todaytopsongs);
        return "melon/chart/todaytopsongs";
    }

    @RequestMapping("/topalbums")
    public String topalbums(ModelMap map) {

        Melon topalbums = skplanetx.getMelon().getChart().getTopAlbums(1, 100);
        map.addAttribute("topalbums", topalbums);
        return "melon/chart/topalbums";
    }

    @RequestMapping("/topgenres")
    public String topgenres(ModelMap map) {

        Melon topgenres = skplanetx.getMelon().getChart().getTopGenres(1, 100);
        map.addAttribute("topgenres", topgenres);
        return "melon/chart/topgenres";
    }

    @RequestMapping("/topgenres/{genreId}")
    public String detailtopgenres(ModelMap map, @PathVariable String genreId) {

        Melon topgenres = skplanetx.getMelon().getChart().getTopGenres(1, 100, genreId);
        map.addAttribute("topgenres", topgenres);
        return "melon/chart/topgenres";
    }

    @RequestMapping("/genres")
    public String genres(ModelMap map) {
        Melon genres = skplanetx.getMelon().getChart().getGenres();
        map.addAttribute("genres", genres);
        return "melon/chart/genres";
    }
}

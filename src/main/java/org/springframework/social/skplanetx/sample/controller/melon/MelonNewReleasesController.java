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
@RequestMapping("/melon/newreleases")
public class MelonNewReleasesController {

    @Autowired
    private Skplanetx skplanetx;

    @RequestMapping("/albums")
    public String albums(ModelMap map) {
        Melon albums = skplanetx.getMelon().getNewReleases().getAlbums(1, 100);
        map.addAttribute("albums", albums);
        return "melon/newreleases/albums";
    }

    @RequestMapping("/albums/{genreId}")
    public String albumsDetail(ModelMap map, @PathVariable String genreId) {
        Melon albums = skplanetx.getMelon().getNewReleases().getAlbums(1, 100, genreId);
        map.addAttribute("albums", albums);
        return "melon/newreleases/albums";
    }

    @RequestMapping("/songs")
    public String songs(ModelMap map) {
        Melon songs = skplanetx.getMelon().getNewReleases().getSongs(1, 100);
        map.addAttribute("songs", songs);
        return "melon/newreleases/songs";
    }

    @RequestMapping("/songs/{genreId}")
    public String songsDetail(ModelMap map, @PathVariable String genreId) {
        Melon songs = skplanetx.getMelon().getNewReleases().getSongs(1, 100, genreId);
        map.addAttribute("songs", songs);
        return "melon/newreleases/songs";
    }
}

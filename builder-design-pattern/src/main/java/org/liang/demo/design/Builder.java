package org.liang.demo.design;

import org.liang.demo.design.material.ceiling.LevelOneCeiling;
import org.liang.demo.design.material.ceiling.LevelTwoCeiling;
import org.liang.demo.design.material.coat.DuluxCoat;
import org.liang.demo.design.material.coat.LiBangCoat;
import org.liang.demo.design.material.floor.ShengXiangFloor;
import org.liang.demo.design.material.tile.DongPengTile;
import org.liang.demo.design.material.tile.MarcoPoloTile;

/**
 * @author liang
 * Date 2020/10/26-20:13
 */
public class Builder {
    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }
}
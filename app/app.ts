import * as app from "tns-core-modules/application";
import { on, run, launchEvent } from "tns-core-modules/application";
import { Frame } from "tns-core-modules/ui/frame/frame";
import { ContentView } from "tns-core-modules/ui/content-view/content-view";
import { TextField } from "tns-core-modules/ui/text-field";
import { Page } from "tns-core-modules/ui/page/page";
import { ActivityIndicator } from "tns-core-modules/ui/activity-indicator";
import { StackLayout } from "tns-core-modules/ui/layouts/stack-layout";
import { Label } from "tns-core-modules/ui/label";
import { ScrollView } from "tns-core-modules/ui/scroll-view";
import { Image } from "tns-core-modules/ui/image";
import { GridLayout, ItemSpec } from "tns-core-modules/ui/layouts/grid-layout";
import { RadSideDrawer } from "nativescript-ui-sidedrawer";
import { BottomNavigation } from "tns-core-modules/ui/bottom-navigation";
import { TabStrip } from "tns-core-modules/ui/tab-navigation-base/tab-strip";
import { TabStripItem } from "tns-core-modules/ui/tab-navigation-base/tab-strip-item";
import { TabContentItem } from "tns-core-modules/ui/tab-navigation-base/tab-content-item";
import { Color } from "tns-core-modules/color";
import * as colors from "tns-core-modules/color/known-colors";
import { LayoutCreator } from "./LayoutCreator";
import {getJSON } from "tns-core-modules/http";
import { ViewModel } from "./Common/ViewModel";
import { EventData, fromObjectRecursive } from "tns-core-modules/data/observable";
import { ListView } from "tns-core-modules/ui/list-view/list-view";



run({
    create: () => {
        const frame = new Frame();
        frame.navigate({
                create: () => {
                    const page = new Page();
                    page.content = LayoutCreator.GetProgressLayout();
                    getJSON<ViewModel>("http://192.168.0.120:8081/GetFormViewModel?form=HomeDetails")
                    .then((ViewModel)=>{
                         page.content = LayoutCreator.GetPageTempate(
                            ViewModel,frame
                        );
                        ViewModel.model.form="HomeDetails";
                        const viewModel = fromObjectRecursive(ViewModel);
                        page.bindingContext=viewModel;
                    }).catch((e)=>{  
                        console.log(e);
                    });
                    return page;
                },
                animated: true,
                transition: {
                    name: "slide",
                    duration: 380,
                    curve: "easeIn"
                }
            });
        return frame;
    }
});

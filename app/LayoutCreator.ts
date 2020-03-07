import {
    GridLayout,
    ItemSpec
} from "tns-core-modules/ui/layouts/grid-layout/grid-layout";
import { ActivityIndicator } from "tns-core-modules/ui/activity-indicator/activity-indicator";
import { Label } from "tns-core-modules/ui/label/label";
import { Button } from "tns-core-modules/ui/button";
import { StackLayout } from "tns-core-modules/ui/layouts/stack-layout/stack-layout";
import { Page, layout, BindingOptions } from "tns-core-modules/ui/page/page";
import { TextField } from "tns-core-modules/ui/text-field/text-field";
import { ScrollView } from "tns-core-modules/ui/scroll-view/scroll-view";
import { getJSON, request } from "tns-core-modules/http";
import { ViewModel } from "./Common/ViewModel";
import { EventData, fromObjectRecursive } from "tns-core-modules/data/observable";
import { ItemEventData, ListView } from "tns-core-modules/ui/list-view";


export class LayoutCreator {
    public static GetProgressLayout() {
        const progressLayout = new GridLayout();
        progressLayout.addRow(new ItemSpec(1, "star"));

        const stack = new StackLayout();

        const progressBar = new ActivityIndicator();
        progressBar.horizontalAlignment = "center";
        progressBar.busy = true;

        const LoadingLabel = new Label();
        LoadingLabel.horizontalAlignment = "center";
        LoadingLabel.text = "Loading";

        stack.addChild(progressBar);
        stack.addChild(LoadingLabel);
        stack.verticalAlignment = "middle";

        progressLayout.addChild(stack);

        return progressLayout;
    }
    public static GetPageTempate(ViewModel, farme): Page {
        const parent = this.GetControlLayout(ViewModel.view.control, farme);
        this.InflateChild(parent, ViewModel.view.control.controls, farme);
        return parent;
    }

    public static InflateChild(parent, controls, frame) {
        for (let i = 0; i < controls.length; i++) {
            const layout = this.GetControlLayout(controls[i], frame);
            parent.addChild(layout);

            if (controls[i].controls) {
                this.InflateChild(layout, controls[i].controls, frame);
            }
            if (controls[i].control) {
                const newlayout = this.GetControlLayout(
                    controls[i].control,
                    frame
                );
                layout.content = newlayout;
                if(controls[i].control.controls){
                    this.InflateChild(
                        newlayout,
                        controls[i].control.controls,
                        frame
                    );
                }
                
            }
        }
    }

    public static GetControlLayout(control, frame) {
        let layout;
        switch (control.type) {
            case "StackLayout":
                layout = this.CreateStackLayout(control);
                break;
            case "Label":
                layout = this.CreateLabel(control);
                break;
            case "Input":
                layout = this.CreateInput(control);
                break;
            case "Caption":
                layout = this.CreateCaption(control);
                break;
            case "GridLayout":
                layout = this.CreateGrid(control);
                break;
            case "Checkbox":
                layout = this.CreateCheckBox(control);
                break;
            case "ScrollView":
                layout = this.CreateScrollView(control);
                break;
            case "Button":
                layout = this.CreateButton(control, frame);
                break;
            case "ListView":
                layout = this.CreateListView(control);
                break;
        }
        return layout;
    }

    public static CreateStackLayout(control) {
        const stack = new StackLayout();
        if (control.orientation) {
            stack.orientation = control.orientation;
        }
        this.SetCommonAttributes(control, stack);
        return stack;
    }
    public static CreateLabel(control) {
        const label = new Label();
        const textbind: BindingOptions = {
            sourceProperty: "model."+control.entityField,
            targetProperty: "text",
            twoWay: true
        };
        this.SetCommonAttributes(control, label);
        label.bind(textbind);
        return label;
    }
    public static CreateInput(control) {
        const input = new TextField();
        this.SetCommonAttributes(control, input);
        const textbind: BindingOptions = {
            sourceProperty: "model."+control.entityField,
            targetProperty: "text",
            twoWay: true
        };
        input.bind(textbind);
        return input;
    }
    public static CreateCaption(control) {
        const label = new Label();
        label.text = "test Caption";
        this.SetCommonAttributes(control, label);
        return label;
    }
    public static CreateButton(control, frame) {
        const button = new Button();
        button.text = "test Caption";
        button.addEventListener("tap", data => {
            this.SetupButtonClick(control, frame, data);
        });
        this.SetCommonAttributes(control, button);
        return button;
    }
    public static CreateGrid(control) {
        const grid = new GridLayout();
        if (control.columns) {
            var columns = control.columns.split(",");
            columns.forEach(column => {
                grid.addColumn(new ItemSpec(1, "star"));
            });
        }
        if (control.rows) {
            var rows = control.rows.split(",");
            rows.forEach(row => {
                grid.addRow(new ItemSpec(1, row));
            });
        }
        this.SetCommonAttributes(control, grid);
        return grid;
    }
    public static CreateCheckBox(control) {
        const label = new Label();
        label.text = "test CheckBox";
        this.SetCommonAttributes(control, label);
        return label;
    }
    public static CreateScrollView(control) {
        const view = new ScrollView();
        this.SetCommonAttributes(control, view);
        return view;
    }
    public static CreateListView(control) {
        const listView = new ListView();
        listView.className = "list-group";
        const bind: BindingOptions = {
            sourceProperty: "model."+control.entityField,
            targetProperty: "items ",
            twoWay: true
        };
        listView.on(ListView.itemLoadingEvent, (args: ItemEventData) => {
            if (!args.view) {
                // Create label if it is not already created.
                args.view = new Label();
                args.view.className = "list-group-item";
            }
            (<any>args.view).text ="Sample";
            
        });
        this.SetCommonAttributes(control, listView);
        return listView;
    }

    public static SetupButtonClick(control, frame, data) {
        switch (control.onClick) {
            case "btnOpenFormClick":
                frame.navigate({
                    create: () => {
                        const page = new Page();
                        page.content = this.GetProgressLayout();
                        getJSON<ViewModel>(
                            "http://192.168.0.120:8081/GetFormViewModel?form=" +
                                control.form
                        )
                            .then(ViewModel => {
                                page.content = LayoutCreator.GetPageTempate(
                                    ViewModel,
                                    frame
                                );
                                const viewModel = fromObjectRecursive(ViewModel);
                                page.bindingContext = viewModel;
                            })
                            .catch(e => {
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
                break;
            case "btnExecuteBusinessMethod":
                var contex=data.object.page.bindingContext._map;
                getJSON({
                    url:
                        "http://192.168.0.120:8081/ExecuteBusinessMethod?form="+ contex.model.form+"&"+"method=LoadPerson",
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    content : JSON.stringify(contex)
                }).then((result)=>{
                    data.object.page.bindingContext=result;
                }).catch((e)=>{
                    console.log(e);
                });
        }
    }
    public static SetCommonAttributes(control, layout) {
        if (control.width) {
            layout.width = control.width;
        }

        if (control.minWidth) {
            layout.minWidth = control.minWidth;
        }
        if (control.minHeight) {
            layout.minHeight = control.minHeight;
        }
        if (control.visibility) {
            layout.visibility = control.visibility;
        }
        if (control.marginTop) {
            layout.marginTop = control.marginTop;
        }
        if (control.marginRight) {
            layout.marginRight = control.marginRight;
        }
        if (control.marginBottom) {
            layout.marginBottom = control.marginBottom;
        }
        if (control.marginLeft) {
            layout.marginLeft = control.marginLeft;
        }
        if (control.paddingTop) {
            layout.paddingTop = control.paddingTop;
        }
        if (control.paddingRight) {
            layout.paddingRight = control.paddingRight;
        }
        if (control.paddingBottom) {
            layout.paddingBottom = control.paddingBottom;
        }
        if (control.paddingLeft) {
            layout.paddingLeft = control.paddingLeft;
        }
        if (control.height) {
            layout.height = control.height;
        }
        if (control.backgroundColor) {
            layout.backgroundColor = control.backgroundColor;
        }
        if (control.horizontalAlignment) {
            layout.horizontalAlignment = control.horizontalAlignment;
        }
        if (control.verticalAlignment) {
            layout.verticalAlignment = control.verticalAlignment;
        }
        if (control.row) {
            layout.row = control.row;
        }
        if (control.row) {
            layout.row = control.row;
        }
        if (control.col) {
            layout.col = control.col;
        }
        if (control.rowSpan) {
            layout.rowSpan = control.rowSpan;
        }
        if (control.colSpan) {
            layout.colSpan = control.colSpan;
        }
        if (control.row) {
            layout.row = control.row;
        }
        if (control.text) {
            layout.text = control.text;
        }
    }
}

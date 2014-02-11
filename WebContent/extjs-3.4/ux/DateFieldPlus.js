Ext.namespace('Ext.ux', 'Ext.ux.form');

if (Ext.form && Ext.form.DateField) {
    Ext.ux.form.DateFieldPlus = Ext.extend(Ext.form.DateField, {
        strict: true,
        usePickerPlus: false,
        showWeekNumber: false,
        noOfMonth: 1,
        noOfMonthPerRow: 3,
        nationalHolidaysCls: 'x-datepickerplus-nationalholidays',
        markNationalHolidays: false,
        eventDates: function(year) {
            return [];
        },
        eventDatesRE: false,
        eventDatesRECls: '',
        eventDatesREText: '',
        multiSelection: false,
        multiSelectionDelimiter: ',',
        multiSelectByCTRL: true,
        fillupRows: true,
/*markWeekends: false,
        weekendText: '',
        weekendCls: 'x-datepickerplus-weekends',
        weekendDays: [6, 0],*/
        useQuickTips: true,
        pageKeyWarp: 1,
        maxSelectionDays: false,
        resizable: false,
        renderTodayButton: true,
        renderOkUndoButtons: false,
        tooltipType: 'qtip',
        allowedDates: true,
        allowedDatesText: '',
        renderPrevNextButtons: true,
        renderPrevNextYearButtons: true,
        disableMonthPicker: false,
        showActiveDate: true,
        shiftSpaceSelect: true,
        disabledLetter: false,
        allowMouseWheel: true,
        summarizeHeader: false,
        stayInAllowedRange: true,
        disableSingleDateSelection: false,
        eventDatesSelectable: false,
        styleDisabledDates: false,
        prevNextDaysView: "mark",

        allowOtherMenus: false,

        onBeforeYearChange: function(picker, oldStartYear, newStartYear) {
            return this.fireEvent("beforeyearchange", this, oldStartYear, newStartYear, picker);
        },

        onAfterYearChange: function(picker, oldStartYear, newStartYear) {
            return this.fireEvent("afteryearchange", this, oldStartYear, newStartYear, picker);
        },

        onBeforeMonthChange: function(picker, oldStartMonth, newStartMonth) {
            return this.fireEvent("beforemonthchange", this, oldStartMonth, newStartMonth, picker);
        },

        onAfterMonthChange: function(picker, oldStartMonth, newStartMonth) {
            return this.fireEvent("aftermonthchange", this, oldStartMonth, newStartMonth, picker);
        },

        onAfterMonthClick: function(picker, month, wasSelected) {
            return this.fireEvent("aftermonthclick", this, month, wasSelected, picker);
        },

        onAfterWeekClick: function(picker, startOfWeek, wasSelected) {
            return this.fireEvent("afterweekclick", this, startOfWeek, wasSelected, picker);
        },

        onAfterDateClick: function(picker, date, wasSelected) {
            return this.fireEvent("afterdateclick", this, date, wasSelected, picker);
        },

        onBeforeMonthClick: function(picker, month, wasSelected) {
            return this.fireEvent("beforemonthclick", this, month, wasSelected, picker);
        },

        onBeforeWeekClick: function(picker, startOfWeek, wasSelected) {
            return this.fireEvent("beforeweekclick", this, startOfWeek, wasSelected, picker);
        },

        onBeforeDateClick: function(picker, date) {
            return this.fireEvent("beforedateclick", this, date);
        },

        onBeforeMouseWheel: function(picker, event) {
            return this.fireEvent("beforemousewheel", this, event, picker);
        },

        onBeforeMaxDays: function(picker) {
            return this.fireEvent("beforemaxdays", this, picker);
        },

        onUndo: function(picker, preSelectedDates) {
            return this.fireEvent("undo", this, preSelectedDates, picker);
        },

        onTriggerClick: function() {
            if (this.disabled) {
                return;
            }
            if (!this.menu) {
                this.menu = new Ext.menu.DateMenu({
                    allowOtherMenus: this.allowOtherMenus,
                    //is needed at initialisation            
                    usePickerPlus: this.usePickerPlus,
                    noOfMonth: this.noOfMonth,
                    noOfMonthPerRow: this.noOfMonthPerRow,
                    listeners: {
                        'beforeyearchange': {
                            fn: this.onBeforeYearChange,
                            scope: this
                        },
                        'afteryearchange': {
                            fn: this.onAfterYearChange,
                            scope: this
                        },
                        'beforemonthchange': {
                            fn: this.onBeforeMonthChange,
                            scope: this
                        },
                        'aftermonthchange': {
                            fn: this.onAfterMonthChange,
                            scope: this
                        },
                        'afterdateclick': {
                            fn: this.onAfterDateClick,
                            scope: this
                        },
                        'aftermonthclick': {
                            fn: this.onAfterMonthClick,
                            scope: this
                        },
                        'afterweekclick': {
                            fn: this.onAfterWeekClick,
                            scope: this
                        },
                        'beforedateclick': {
                            fn: this.onBeforeDateClick,
                            scope: this
                        },
                        'beforemonthclick': {
                            fn: this.onBeforeMonthClick,
                            scope: this
                        },
                        'beforeweekclick': {
                            fn: this.onBeforeWeekClick,
                            scope: this
                        },
                        'beforemousewheel': {
                            fn: this.onBeforeMouseWheel,
                            scope: this
                        },
                        'beforemaxdays': {
                            fn: this.onBeforeMaxDays,
                            scope: this
                        },
                        'undo': {
                            fn: this.onUndo,
                            scope: this
                        }
                    }
                });
                //do this only once!                                    
                this.relayEvents(this.menu, ["select"]);
            }

            if (this.menu.isVisible()) {
                this.menu.hide();
                return;
            }
            if (this.disabledDatesRE) {
                this.ddMatch = this.disabledDatesRE;
            }
            if (typeof this.minDate == "string") {
                this.minDate = this.parseDate(this.minDate);
            }
            if (typeof this.maxDate == "string") {
                this.maxDate = this.parseDate(this.maxDate);
            }

            Ext.apply(this.menu.picker, {
                minDate: this.minValue || this.minDate,
                maxDate: this.maxValue || this.maxDate,
                disabledDatesRE: this.ddMatch,
                disabledDatesText: this.disabledDatesText,
                disabledDays: this.disabledDays,
                disabledDaysText: this.disabledDaysText,
                showToday: this.showToday,
                //from Ext 2.2 
                format: this.format,
                minText: String.format(this.minText, this.formatDate(this.minValue || this.minDate)),
                maxText: String.format(this.maxText, this.formatDate(this.maxValue || this.maxDate)),
                showWeekNumber: this.showWeekNumber,
                nationalHolidaysCls: this.nationalHolidaysCls,
                markNationalHolidays: this.markNationalHolidays,
                multiSelectByCTRL: this.multiSelectByCTRL,
                fillupRows: this.fillupRows,
                multiSelection: this.multiSelection,
                markWeekends: this.markWeekends,
                weekendText: this.weekendText,
                weekendCls: this.weekendCls,
                weekendDays: this.weekendDays,
                useQuickTips: this.useQuickTips,
                eventDates: this.eventDates,
                eventDatesRE: this.eventDatesRE,
                eventDatesRECls: this.eventDatesRECls,
                eventDatesREText: this.eventDatesREText,
                pageKeyWarp: this.pageKeyWarp,
                maxSelectionDays: this.maxSelectionDays,
                resizable: this.resizable,
                renderTodayButton: this.renderTodayButton,
                renderOkUndoButtons: this.renderOkUndoButtons,
                allowedDates: this.allowedDates,
                allowedDatesText: this.allowedDatesText,
                renderPrevNextButtons: this.renderPrevNextButtons,
                renderPrevNextYearButtons: this.renderPrevNextYearButtons,
                disableMonthPicker: this.disableMonthPicker,
                showActiveDate: this.showActiveDate,
                shiftSpaceSelect: this.shiftSpaceSelect,
                disabledLetter: this.disabledLetter,
                allowMouseWheel: this.allowMouseWheel,
                summarizeHeader: this.summarizeHeader,
                stayInAllowedRange: this.stayInAllowedRange,
                disableSingleDateSelection: this.disableSingleDateSelection,
                eventDatesSelectable: this.eventDatesSelectable,
                styleDisabledDates: this.styleDisabledDates,
                prevNextDaysView: this.prevNextDaysView
            });
            //Ext 3.0 
            if (this.menuEvents) {
                this.menuEvents('on');
            } else {
                //ext 2.2.x                              
                this.menu.on(Ext.apply({}, this.menuListeners, {
                    scope: this
                }));
            }
            if (typeof this.defaultValue == 'string') {
                this.defaultValue = Date.parseDate(this.defaultValue, this.format);
            }

            this.menu.picker.setValue(this.getValue() || this.defaultValue || new Date());
            this.menu.show(this.el, "tl-bl?");
            this.menu.focus();
        },

        setValue: function(date) {
            var field = this;
            if (Ext.isArray(date)) {
                var formatted = [];
                for (var e = 0, el = date.length; e < el; ++e) {
                    formatted.push(field.formatDate(date[e]));
                }

                var value = formatted.join(this.multiSelectionDelimiter);

                //bypass setValue validation on Ext.DateField 
                Ext.form.DateField.superclass.setValue.call(this, value);
            } else {
                Ext.form.DateField.superclass.setValue.call(this, this.formatDate(this.parseDate(date)));
            }
        },
        validateValue: function(value) {
            if (this.multiSelection) {
                var field = this;
                var values = value.split(this.multiSelectionDelimiter);
                var isValid = true;
                for (var e = 0, el = values.length; e < el; ++e) {
                    if (!Ext.ux.form.DateFieldPlus.superclass.validateValue.call(field, values[e])) {
                        isValid = false;
                    }
                }
                return isValid;
            } else {
                return Ext.ux.form.DateFieldPlus.superclass.validateValue.call(this, value);
            }
        },

        getValue: function() {
            if (this.multiSelection) {
                var value = Ext.form.DateField.superclass.getValue.call(this);
                var field = this;
                var values = value.split(this.multiSelectionDelimiter);
                var dates = [];
                for (var e = 0, el = values.length; e < el; ++e) {
                    var checkDate = field.parseDate(values[e]);
                    if (checkDate) {
                        dates.push(checkDate);
                    }
                }
                return (dates.length > 0 ? dates : "");
            } else {
                return Ext.ux.form.DateFieldPlus.superclass.getValue.call(this);
            }
        },


        beforeBlur: function() {
            if (this.multiSelection) {
                this.setValue(this.getRawValue().split(this.multiSelectionDelimiter));
            } else {
                var v = this.parseDate(this.getRawValue());
                if (v) {
                    this.setValue(v);
                }
            }
        },



        submitFormat: 'm/d/Y',
        submitFormatAddon: '-format',
        onRender: function() {

            Ext.ux.form.DateFieldPlus.superclass.onRender.apply(this, arguments);
            //be sure not to have duplicate formfield names (at least IE moans about it and gets confused)                          
            //                              this.name =  (typeof this.name==="undefined"?this.id+this.submitFormatAddon:(this.name==this.id?this.name+this.submitFormatAddon:this.name));            
            var name = this.name || this.el.dom.name || (this.id + this.submitFormatAddon);
            if (name == this.id) {
                name += this.submitFormatAddon;
            }
            var hiddenValue = "";
            if (this.value != null && this.value != undefined) {
                hiddenValue = this.formatHiddenDate(this.parseDate(this.value));
            }
            this.hiddenField = this.el.insertSibling({
                tag: 'input',
                type: 'hidden',
                name: name,
                value: hiddenValue
            });
            this.hiddenName = name;
            this.el.dom.removeAttribute('name');
            this.el.on({
                keyup: {
                    scope: this,
                    fn: this.updateHidden
                },
                blur: {
                    scope: this,
                    fn: this.updateHidden
                }
            });

            this.setValue = this.setValue.createSequence(this.updateHidden);

            if (this.tooltip) {
                if (typeof this.tooltip == 'object') {
                    Ext.QuickTips.register(Ext.apply({
                        target: this.trigger
                    }, this.tooltip));
                } else {
                    this.trigger.dom[this.tooltipType] = this.tooltip;
                }
            }


        },
        afterRender: function() {
            Ext.ux.form.DateFieldPlus.superclass.afterRender.apply(this, arguments);
            this.format = Ext.bridgex.ApplicationComponent.getUserDateFormat();
        },
        onDisable: function() {
            Ext.ux.form.DateFieldPlus.superclass.onDisable.apply(this, arguments);
            if (this.hiddenField) {
                this.hiddenField.dom.setAttribute('disabled', 'disabled');
            }
        },

        onEnable: function() {
            Ext.ux.form.DateFieldPlus.superclass.onEnable.apply(this, arguments);
            if (this.hiddenField) {
                this.hiddenField.dom.removeAttribute('disabled');
            }
        },

        formatHiddenDate: function(date) {
            return Ext.isDate(date) ? Ext.util.Format.date(date, this.submitFormat) : date;
        },

        formatMultiHiddenDate: function(date) {
            var field = this,
                formatted = [],
                value;
            for (var e = 0, el = date.length; e < el; ++e) {
                formatted.push(field.formatHiddenDate(date[e]));
            }
            value = formatted.join(this.multiSelectionDelimiter);
            this.hiddenField.dom.value = value;
        },

        updateHidden: function(date) {
            if (Ext.isArray(date)) {
                this.formatMultiHiddenDate(date);
            } else {
                var value = this.getValue();
                if (Ext.isArray(value)) {
                    this.formatMultiHiddenDate(value);
                } else {
                    this.hiddenField.dom.value = this.formatHiddenDate(value);
                }
            }
        },
        safeParse: function(value, format) {
            if (Date.formatContainsHourInfo(format)) {
                // if parse format contains hour information, no DST adjustment is necessary
                return Date.parseDate(value, format, this.strict);
            } else {
                // set time to 12 noon, then clear the time
                var parsedDate = Date.parseDate(value + ' ' + this.initTime, format + ' ' + this.initTimeFormat, this.strict);

                if (parsedDate) {
                    return parsedDate.clearTime();
                }
            }
        },
        getSubmitFormatDate: function() {
            return this.formatHiddenDate(this.getValue());
        }
    });
    Ext.reg('datefieldplus', Ext.ux.form.DateFieldPlus);
}

Ext.ux.form.DateDisplayField = Ext.extend(Ext.form.DisplayField, {
    constructor: function(config) {
        var config = config || {};
        Ext.applyIf(config, {
            dateFormat: 'm/d/Y',
            displayFormat: 'm/d/Y'
            	
        });
        Ext.ux.form.DateDisplayField.superclass.constructor.call(this, config);
    },
    afterRender: function() {
        Ext.ux.form.DateDisplayField.superclass.afterRender.apply(this, arguments);
        this.displayFormat = Ext.bridgex.ApplicationComponent.getUserDateFormat();
    },
    setValue: function(value) {
        var parsedDate = Date.parseDate(value, this.dateFormat);
        if (Ext.isDate(parsedDate)) {
            this.setRawValue(parsedDate.format(this.displayFormat));
        } else {
            this.setRawValue(value);
        }
    }
});
Ext.reg('datedisplayfield', Ext.ux.form.DateDisplayField);
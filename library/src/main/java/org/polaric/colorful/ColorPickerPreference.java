package org.polaric.colorful;
import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ColorPickerPreference extends Preference implements ColorPickerDialog.OnColorSelectedListener {
    private boolean primary;
    private boolean accent;

    public ColorPickerPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWidgetLayoutResource(R.layout.preference_colorpicker);

        TypedArray ta = context.obtainStyledAttributes(R.styleable.colorpicker);
        try {
            primary = ta.getBoolean(R.styleable.colorpicker_primary_color,false);
            accent = ta.getBoolean(R.styleable.colorpicker_accent_color, false);
        } finally {
            ta.recycle();
        }
    }

    @Override
    public void onColorSelected(Colorful.ThemeColor color) {
        if (primary) {
            Colorful.Config.primaryColor(color);
            Colorful.Config.apply(getContext());
        } else if (accent) {
            Colorful.Config.accentColor(color);
            Colorful.Config.apply(getContext());
        }
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        View root = super.onCreateView(parent);
        if (primary) {
            ((CircularView) root.findViewById(R.id.color_indicator)).setColor(getContext().getResources().getColor(Colorful.getThemeDelegate().getPrimaryColor().getColorRes()));
        } else if (accent) {
            ((CircularView) root.findViewById(R.id.color_indicator)).setColor(getContext().getResources().getColor(Colorful.getThemeDelegate().getAccentColor().getColorRes()));
        }
        return root;
    }

    @Override
    protected void onClick() {
        super.onClick();
        new ColorPickerDialog(getContext()).show();
    }
}

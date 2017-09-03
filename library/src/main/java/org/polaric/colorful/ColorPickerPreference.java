package org.polaric.colorful;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;

public class ColorPickerPreference extends Preference implements ColorPickerDialog.OnColorSelectedListener {
    private boolean primary;
    private boolean accent;

    public ColorPickerPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWidgetLayoutResource(R.layout.preference_colorpicker);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.colorpicker);
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
            Colorful.config(getContext())
                    .primaryColor(color)
                    .apply();
        } else if (accent) {
            Colorful.config(getContext())
                    .accentColor(color)
                    .apply();
        }
        if (getOnPreferenceChangeListener()!=null) {
            getOnPreferenceChangeListener().onPreferenceChange(this, color);
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        if (primary) {
            ((CircularView) holder.findViewById(R.id.color_indicator)).setColor(getContext().getResources().getColor(Colorful.getThemeDelegate().getPrimaryColor().getColorRes()));
        } else if (accent) {
            ((CircularView) holder.findViewById(R.id.color_indicator)).setColor(getContext().getResources().getColor(Colorful.getThemeDelegate().getAccentColor().getColorRes()));
        }
    }

    @Override
    protected void onClick() {
        super.onClick();
        ColorPickerDialog dialog = new ColorPickerDialog(getContext());
        dialog.setOnColorSelectedListener(this);
        dialog.show();
    }
}

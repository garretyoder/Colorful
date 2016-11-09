package org.polaric.colorful;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ColorPickerDialog extends Dialog implements View.OnClickListener, ColorPickerAdapter.OnItemClickListener {
    private RecyclerView recycler;
    private Toolbar toolbar;
    private OnColorSelectedListener listener;

    public ColorPickerDialog(Context context) {
        super(context);
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }

    @Override
    public void onItemClick(Colorful.ThemeColor color) {
        dismiss();
        if (listener!=null) {
            listener.onColorSelected(color);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_colorpicker);

        recycler = ((RecyclerView) findViewById(R.id.colorful_color_picker_recycler));
        toolbar = ((Toolbar) findViewById(R.id.colorful_color_picker_toolbar));

        toolbar.setNavigationOnClickListener(this);
        toolbar.setBackgroundColor(getContext().getResources().getColor(Colorful.getThemeDelegate().getPrimaryColor().getColorRes()));
        toolbar.setTitle(R.string.select_color);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_48px);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 4));
        ColorPickerAdapter adapter = new ColorPickerAdapter(getContext());
        adapter.setOnItemClickListener(this);
        recycler.setAdapter(adapter);
    }

    public interface OnColorSelectedListener {
        void onColorSelected(Colorful.ThemeColor color);
    }

    public void setOnColorSelectedListener(OnColorSelectedListener listener) {
        this.listener=listener;
    }
}

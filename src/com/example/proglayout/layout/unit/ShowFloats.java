package com.example.proglayout.layout.unit;

import android.view.View;
import android.widget.TextView;

import com.example.proglayout.csound.listener.CachedOutputNamesFloat;
import com.example.proglayout.layout.Layout;
import com.example.proglayout.layout.LayoutContext;
import com.example.proglayout.layout.SetLayoutParam.LayoutParent;
import com.example.proglayout.layout.UnitUtils;
import com.example.proglayout.layout.UnitUtils.WithId;
import com.example.proglayout.layout.Units;
import com.example.proglayout.layout.Units.Unit;
import com.example.proglayout.model.TrackState;
import com.example.proglayout.view.param.Param;

public class ShowFloats implements Unit {
	
	@Override
	public String getTag() {	
		return Units.SHOW_FLOATS;
	}
	
	@Override
	public View getView(final LayoutContext ctx, Object tagValue,
			final Param param, Param defaultParams, TrackState trackState, final LayoutParent layoutParent) {
		
		return UnitUtils.run(this, ctx, tagValue, new WithId() {
			@Override
			public View apply(String id) {
				TextView tv = new TextView(ctx.getContext());
				Layout.setTextProperties(tv, param.getText());
				new CachedOutputNamesFloat(id, tv).addToCsound(ctx.getApp());				
				return tv;				
			}
		});		
		
	}

}
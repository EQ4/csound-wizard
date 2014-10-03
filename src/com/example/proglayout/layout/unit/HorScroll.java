package com.example.proglayout.layout.unit;

import android.view.View;
import android.widget.HorizontalScrollView;

import com.example.proglayout.layout.Json;
import com.example.proglayout.layout.Layout;
import com.example.proglayout.layout.LayoutContext;
import com.example.proglayout.layout.SetLayoutParam.LayoutParent;
import com.example.proglayout.layout.Units;
import com.example.proglayout.layout.Units.Unit;
import com.example.proglayout.model.TrackState;
import com.example.proglayout.view.param.Param;

public class HorScroll implements Unit {
	
	@Override
	public String getTag() {	
		return Units.HOR_SCROLL;
	}
	
	@Override
	public View getView(LayoutContext ctx, Object tagValue, final Param param, final Param defaults, TrackState trackState, final LayoutParent layoutParent) {
		HorizontalScrollView res = new HorizontalScrollView(ctx.getContext());		
		if (Json.isArray(tagValue)) {
			res.addView(new Hor().getView(ctx, tagValue, param, defaults, trackState, LayoutParent.HOR));
		} else {
			res.addView(Layout.getView(ctx, tagValue, defaults, LayoutParent.HOR, trackState));
		}	
		return res;
	}
	
}
package com.samir;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NamesAdapter extends ArrayAdapter<Item> {

	private ArrayList<Item> items;
	private LayoutInflater vi;
	private Item objItem;

	ViewHolderSectionName holderSection;
	ViewHolderName holderName;

	public NamesAdapter(Context context, ArrayList<Item> items) {
		super(context, 0, items);

		this.items = items;
		vi = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		objItem = items.get(position);

		if (objItem.isSectionItem()) {
			ItemsSections si = (ItemsSections) objItem;

			if (convertView == null
					|| !convertView.getTag().equals(holderSection)) {
				convertView = vi.inflate(R.layout.alphabet_separator, null);

				holderSection = new ViewHolderSectionName();
				convertView.setTag(holderSection);
			} else {
				holderSection = (ViewHolderSectionName) convertView.getTag();
			}

			holderSection.section = (TextView) convertView
					.findViewById(R.id.alphabet_letter);
			holderSection.section
					.setText(String.valueOf(si.getSectionLetter()));

		} else {
			Items ei = (Items) objItem;

			if (convertView == null || !convertView.getTag().equals(holderName)) {
				convertView = vi.inflate(R.layout.row, null);

				holderName = new ViewHolderName();
				convertView.setTag(holderName);
			} else {
				holderName = (ViewHolderName) convertView.getTag();
			}

			holderName.name = (TextView) convertView.findViewById(R.id.tvname);

			if (holderName.name != null)
				holderName.name.setText(ei.getName());
		}
		return convertView;
	}

	public static class ViewHolderName {
		public TextView name;
	}

	public static class ViewHolderSectionName {
		public TextView section;
	}
}

/*
 * ecoCode iOS plugin - Help the earth, adopt this green plugin for your applications
 * Copyright © 2022 Green code Initiative (https://www.ecocode.io/)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.ecocode.ios.swift.checks.idleness;

import io.ecocode.ios.swift.RegisterRule;
import io.ecocode.ios.swift.Swift;
import io.ecocode.ios.swift.antlr.generated.Swift5Parser;
import io.ecocode.ios.checks.RuleCheck;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Check the presence of the class "Timer".
 */
@RegisterRule
public class RigidAlarmCheck extends RuleCheck {

    public RigidAlarmCheck() {
        super("EIDL002", Swift.RULES_PATH, Swift.REPOSITORY_KEY);
    }

    @Override
    public void apply(ParseTree tree) {
        if (tree instanceof Swift5Parser.IdentifierContext) {
            Swift5Parser.IdentifierContext id = (Swift5Parser.IdentifierContext) tree;
            if (id.getText().equals("Timer")) {
                this.recordIssue(ruleId, id.getStart().getStartIndex());
            }
        }
    }

}
